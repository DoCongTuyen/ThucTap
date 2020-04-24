import {Component, OnInit} from '@angular/core';
import {IssueModel} from "../../../shared/model/Issue/issue.model";
import {IssueService} from "../../../core/issue/issue.service";
import {ActivatedRoute} from "@angular/router";
import {IssueHistoryService} from "../../../core/issue-history/issue-history.service";
import {IssueHistoryModel} from "../../../shared/model/issue-history/issue-history.model";

@Component({
    selector: 'smart-issue-history',
    templateUrl: './issue-history.component.html',
    styleUrls: ['./issue-history.component.css']
})
export class IssueHistoryComponent implements OnInit {
    issue: IssueModel = new IssueModel();
    issueHistoryModels: IssueHistoryModel[];
    issueHistoryModel: IssueHistoryModel = new IssueHistoryModel();

    constructor(private issueService: IssueService,
                private  router: ActivatedRoute,
                private issueHistory: IssueHistoryService) {
    }

    ngOnInit() {
        const id = this.router.snapshot.params.id;
        this.issueService.getIssue(id).subscribe(data => {
            this.issue = data;
        });
        this.issueHistory.getHistory().subscribe(data => {
                this.issueHistoryModels = data;
                console.log(data);
            })

    }

    // getHistory() {
    //     this.issueHistory.getHistory().subscribe(data => {
    //         this.issueHistoryModels = data;
    //         console.log(data);
    //     })
    // }


}
