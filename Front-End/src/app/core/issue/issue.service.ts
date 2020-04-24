import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {IssueModel} from "../../shared/model/Issue/issue.model";
import {AppConfigService} from "../../app-config.service";
import {StatusTypeModel} from "../../shared/model/status-type/status-type.model";
import {StatusModel} from "../../shared/model/status/status.model";
import {catchError, retry} from "rxjs/operators";
import {SearchIssueModel} from "../../shared/model/response/SearchIssue.model";


@Injectable({
    providedIn: 'root'
})
export class IssueService {

    constructor(private http: HttpClient, private config: AppConfigService) {
    }

    public getIssues(): Observable<IssueModel[]> {
        return this.http.get<IssueModel[]>(`${this.config.getAPIEndPoint()}/issue/get-all`);
    }

    public saveIssue(issueModel: IssueModel) {
        return this.http.post<IssueModel>(`${this.config.getAPIEndPoint()}/issue/create`, issueModel);
    }

    public deleteIssue(issueModel: IssueModel) {
        return this.http.delete(`${this.config.getAPIEndPoint()}/issue/delete/${issueModel.id}`);
    }


    getIssue(id: number): Observable<any> {
        return this.http.get(`${this.config.getAPIEndPoint()}/issue/find-one/${id}`);
    }

    public updateIssue(issueModel: IssueModel) {
        return this.http.put(`${this.config.getAPIEndPoint()}/issue/update`, issueModel);

    }

    getAllParams(searchIssue: SearchIssueModel): Observable<any> {
        return this.http.post(`${this.config.getAPIEndPoint()}/issue/issue-by-params`, searchIssue).pipe(
            retry(2),
            catchError((err) => {
                return throwError(err);
            })
        );
    }

    deleteByIds(listIdChecked: number[]): Observable<any> {
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            body: listIdChecked
        };
        return this.http.delete(`${this.config.getAPIEndPoint()}/issue/delete`, httpOptions)
            .pipe(catchError(err => {
                return throwError(err);
            }));
    }
}
