import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {AppConfig} from "@ngrx/store/schematics-core";
import {AppConfigService} from "../../app-config.service";
import {Observable} from "rxjs";
import {NewsModel} from "../../shared/model/news/news.model";

@Injectable({
    providedIn: 'root'
})
export class NewsService {


    constructor(private http: HttpClient, private config: AppConfigService) {
    }

    public getAll(): Observable<NewsModel[]> {
        return this.http.get<NewsModel[]>(`${this.config.getAPIEndPoint()}/news`);
    }

    public create(newsModel: NewsModel): Observable<NewsModel> {
        return this.http.post<NewsModel>(`${this.config.getAPIEndPoint()}/news/add`, newsModel);
    }

    public getNews(id: number): Observable<any> {
        return this.http.get(`${this.config.getAPIEndPoint()}/news/find-one/${id}`);
    }

    doUpload(file: File): Observable<HttpEvent<{}>> {
        const data: FormData = new FormData(); // k can submit form, dung ajax de gui du lieu form
        data.append('file', file); // Phương thức append cho phép chúng ta chèn thêm một cặp key => value vào trong FormData
        const newRequest = new HttpRequest('POST', 'http://localhost:8082/api/upload', data, {
            reportProgress: true,
            responseType: 'text'
        });
        return this.http.request(newRequest);
    }
}
