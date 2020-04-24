import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SharedModule} from "../../shared/shared.module";
import {GridModule} from "@progress/kendo-angular-grid";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";
import {PaginationModule} from "ngx-bootstrap";
import {CKEditorModule} from "ngx-ckeditor";
import {RouterModule} from "@angular/router";
import {QuanLyNewsComponent} from "./quan-ly-news.component";
import {AngularFontAwesomeModule} from "angular-font-awesome";
import { NewsSingleComponent } from './news-single/news-single.component';

@NgModule({
    declarations: [QuanLyNewsComponent],
    imports: [
        SharedModule,
        GridModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        NgxPaginationModule,
        PaginationModule.forRoot(),
        CommonModule,
        CKEditorModule,
        AngularFontAwesomeModule,
        RouterModule.forChild([
            {path: '', pathMatch: 'full', redirectTo: 'news'},
            {
                path: 'news', component: QuanLyNewsComponent,
                // data: {breadcrumbs: ['QuanLyIssue', '']}
            },
        ])
    ]
})
export class QuanLyNewsModule {
}
