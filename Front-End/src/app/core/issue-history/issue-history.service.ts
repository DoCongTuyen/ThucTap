import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IssueHistoryModel} from "../../shared/model/issue-history/issue-history.model";
import {AppConfigService} from "../../app-config.service";
import {IssueModel} from "../../shared/model/Issue/issue.model";

@Injectable({
    providedIn: 'root'
})
export class IssueHistoryService {

    constructor(private http: HttpClient, private config: AppConfigService) {
    }

    getHistory(): Observable<IssueHistoryModel[]> {
        return this.http.get<IssueHistoryModel[]>(`${this.config.getAPIEndPoint()}/issueHistory/`);
    }

    public saveIssue(issueHistoryModel: IssueHistoryModel) {
        return this.http.post<IssueHistoryModel>(`${this.config.getAPIEndPoint()}/issueHistory/create`, issueHistoryModel);
    }

}
