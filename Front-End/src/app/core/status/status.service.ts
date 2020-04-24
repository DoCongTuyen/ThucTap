import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppConfigService} from "../../app-config.service";
import {Observable} from "rxjs";
import {ProjectModel} from "../../shared/model/project/project.model";
import {StatusModel} from "../../shared/model/status/status.model";

@Injectable({
    providedIn: 'root'
})
export class StatusService {

    constructor(private http: HttpClient, private config: AppConfigService) {
    }

    public getStatus(): Observable<StatusModel[]> {
        return this.http.get<StatusModel[]>(`${this.config.getAPIEndPoint()}/status/getAll`);
    }
}
