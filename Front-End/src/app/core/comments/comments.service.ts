import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CommentsModel} from "../../shared/model/comments/comments.model";
import {AppConfigService} from "../../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  constructor(private http: HttpClient, private config: AppConfigService) { }

  getComments(): Observable<CommentsModel[]> {
    return this.http.get<CommentsModel[]>(`${this.config.getAPIEndPoint()}/comments`);
  }
  saveComments(commentsModel: CommentsModel) {
    return this.http.post<CommentsModel>(`${this.config.getAPIEndPoint()}/comments/create`,commentsModel);
  }
}
