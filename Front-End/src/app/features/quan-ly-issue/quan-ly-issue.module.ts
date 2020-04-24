import {NgModule} from "@angular/core";
import {QuanLyIssueComponent} from "./quan-ly-issue.component"
import {RouterModule} from "@angular/router";
import {SharedModule} from '../../shared/shared.module';
import {GridModule} from '@progress/kendo-angular-grid';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from "@angular/common";
import {InsertUpdateIssueComponent} from './insert-update-issue/insert-update-issue.component';
import {CKEditorModule} from "ngx-ckeditor";
import {PaginationModule} from "ngx-bootstrap";
import {NgxPaginationModule} from "ngx-pagination";
import {IssueHistoryComponent} from './issue-history/issue-history.component';

@NgModule({
    declarations: [QuanLyIssueComponent, InsertUpdateIssueComponent, IssueHistoryComponent],
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
        RouterModule.forChild([
            {path: '', pathMatch: 'full', redirectTo: 'issue'},
            {
                path: 'issue', component: QuanLyIssueComponent,
                data: {breadcrumbs: ['QuanLyIssue', '']}
            },
            {path: 'issue/add', component: InsertUpdateIssueComponent},
            {path: 'issue/history/:id', component: IssueHistoryComponent}
        ]),

    ], exports: [
        PaginationModule,
        NgxPaginationModule
    ]
})
export class QuanLyIssueModule {

}
