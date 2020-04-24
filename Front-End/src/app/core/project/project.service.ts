import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppConfigService} from "../../app-config.service";
import {Observable} from "rxjs";
import {ProjectModel} from "../../shared/model/project/project.model";

@Injectable({
    providedIn: 'root'
})
export class ProjectService {

    constructor(private http: HttpClient, private config: AppConfigService) {
    }

    public getProject(): Observable<ProjectModel[]> {
        return this.http.get<ProjectModel[]>(`${this.config.getAPIEndPoint()}/project/getAll`);
    }
}
