import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {IssueModel} from "../../shared/model/Issue/issue.model";
import {IssueService} from "../../core/issue/issue.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {InsertUpdateIssueComponent} from "./insert-update-issue/insert-update-issue.component";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {ProjectModel} from "../../shared/model/project/project.model";
import {StatusModel} from "../../shared/model/status/status.model";
import {ProjectService} from "../../core/project/project.service";
import {StatusService} from "../../core/status/status.service";
import {first} from "rxjs/operators";
import {SearchIssueModel} from "../../shared/model/response/SearchIssue.model";
import {IssueHistoryService} from "../../core/issue-history/issue-history.service";
import {IssueHistoryModel} from "../../shared/model/issue-history/issue-history.model";


@Component({
    selector: 'smart-quan-ly-issue',
    templateUrl: './quan-ly-issue.component.html',
    styleUrls: ['./quan-ly-issue.component.css']
})
export class QuanLyIssueComponent implements OnInit {
    issues: IssueModel[];
    a: any;
    searchResponse: SearchIssueModel = new SearchIssueModel();
    issue: IssueModel = new IssueModel();
    issueUpdate: IssueModel;
    project: ProjectModel[];
    projectIdSelected: any;
    status: StatusModel[];
    statusIdSelected: any;
    masterSelected: boolean;
    updateForm: FormGroup;
    date = new Date();
    issueHistoryModel: IssueHistoryModel = new IssueHistoryModel();
    listIdChecked: number[] = [];
    pageOptions: any = {
        page: 0,
        pageSize: 5,
        totalPages: 0,
        totalRows: 0
    }

    constructor(private issueService: IssueService,
                private projectService: ProjectService,
                private statusService: StatusService,
                public modal: NgbModal,
                private router: Router,
                private issueHistory: IssueHistoryService) {

        this.updateForm = new FormGroup({
            id: new FormControl(),
            name: new FormControl(),
            startDate: new FormControl(),
            dueDate: new FormControl(),
            donePercent: new FormControl(),
            priority: new FormControl(),
            reason: new FormControl(),
            type: new FormControl(),
            description: new FormControl(),
            projectId: new FormControl(),
            statusId: new FormControl()
        });
        // this.doSearch();
    }


    ngOnInit() {
        this.searchResponse.page = this.pageOptions.page;
        this.searchResponse.pageSize = this.pageOptions.pageSize;
        this.issueService.getIssues().subscribe(data => {
            this.issues = data;

        }),
            this.projectService.getProject().subscribe(data => {
                this.project = data;
            }),
            this.statusService.getStatus().subscribe(data => {
                this.status = data;
            })

        // this.searchResponse.page = 0;
        // this.searchResponse.pageSize = 5;
        this.doSearch();
        // this.searchResponse.page = this.pageOptions.page;
        // this.searchResponse.pageSize = this.pageOptions.pageSize;
        console.log(this.date);
    }
    onDelete(issue: IssueModel) {
        const kq = confirm("ban co muon xoa khong?");
        if (kq) {
            this.issueService.deleteIssue(issue).subscribe(data => {
                this.issues = this.issues.filter(u => u !== issue);
                // filter lấy về 1 phần tử đáp ứng điều kiện
            });
        } else {
            console.log("huy xoa");
        }

    }

    gotoListIssue() {
        return this.router.navigate(['/quan-ly-issue/issue']);
    }


    handlerProjectIdSelected(event: any) {
        // console.log(event.target.value);
        this.projectIdSelected = event.target.value;
    }

    handlerStatusIdSelected(event: any) {
        // console.log(event.target.value);
        this.statusIdSelected = event.target.value;
    }

    onUpdate(id: number) {
        this.issueHistoryModel.issueId= id;
        this.issueService.getIssue(id).subscribe(data => {
            this.issue = data;
        });
    }

    updateIssue(id: number) {
        this.issueService.updateIssue(this.issue).subscribe(
            data => this.gotoListIssue());
        this.router.navigate(['']);
        this.createIssueHistory();
    }

    createIssueHistory() {
        this.issueHistoryModel.updateDate = this.date;
        this.issueHistoryModel.upLoadPersonId = 1;
        this.issueHistory.saveIssue(this.issueHistoryModel).subscribe();
    }

    doSearch() {
        this.searchResponse.page = this.pageOptions.page;
        this.searchResponse.pageSize = this.pageOptions.pageSize;
        if(this.searchResponse.startDate > this.searchResponse.endDate ){
            alert("vui lòng chọn khoảng ngày phù hợp")
        }else {
            this.issueService.getAllParams(this.searchResponse).subscribe(data => {
                if (data.code === '00') {
                    // console.log(data);
                    this.issues = data.datas;
                    this.pageOptions.totalPages = data.totalPages;
                    this.pageOptions.totalRows = data.totalRows;
                }
            })
        }
    }

    onPageChange(event) {
        // console.log("---",event);
        this.pageOptions.page = event.page - 1;
        this.pageOptions.pageSize = event.itemsPerPage;
        this.doSearch();
    }

    selectAll() {
        for (let i = 0; i < this.issues.length; i++) {
            this.issues[i].selected = this.masterSelected;
            this.listIdChecked.push(this.issues[i].id);
        }
    }

    checkIfAllSelected(event) {
        this.masterSelected = this.issues.every(function (item: any) {
            return item.selected == true;
        })
        this.listIdChecked.push(event.target.value);
    }

    deleteByIds() {
        this.issueService.deleteByIds(this.listIdChecked).subscribe(data => {
            this.ngOnInit();
        });
    }
}
