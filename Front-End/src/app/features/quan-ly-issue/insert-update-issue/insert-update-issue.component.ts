import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {IssueService} from "../../../core/issue/issue.service";
import {ActivatedRoute, Router} from '@angular/router';
import {IssueModel} from "../../../shared/model/Issue/issue.model";
import {ProjectService} from "../../../core/project/project.service";
import {ProjectModel} from "../../../shared/model/project/project.model";
import {StatusModel} from "../../../shared/model/status/status.model";
import {StatusService} from "../../../core/status/status.service";

@Component({
    selector: 'smart-insert-update-issue',
    templateUrl: './insert-update-issue.component.html',
    styleUrls: ['./insert-update-issue.component.css']
})
export class InsertUpdateIssueComponent implements OnInit {
    issue: IssueModel;
    project: ProjectModel[];
    projectIdSelected: any;
    statusIdSelected: any;
    status: StatusModel[];

    constructor(
        private issueService: IssueService,
        private projectService: ProjectService,
        private statusServicce: StatusService,
        private router: Router) {
        this.issue = new IssueModel();

    }

    handlerProjectIdSelected(event: any) {
        console.log(event.target.value);
        this.projectIdSelected = event.target.value;
    }

    handlerStatusIdSelected(event: any) {
        // console.log(event.target.value);
        this.statusIdSelected = event.target.value;
    }

    ngOnInit() {
        this.projectService.getProject().subscribe(data => {
            this.project = data;
        });
        this.statusServicce.getStatus().subscribe(data => {
            this.status = data;
        })

    }
    gotoListIssue() {
        return this.router.navigate(['/quan-ly-issue/issue']);
    }
    onSubmit(issueForm) {
        this.issue.projectId=this.projectIdSelected;
        this.issue.statusId=this.statusIdSelected;
        this.issueService.saveIssue(this.issue).subscribe(result => this.gotoListIssue());
        console.log(issueForm.value);
    }


}
