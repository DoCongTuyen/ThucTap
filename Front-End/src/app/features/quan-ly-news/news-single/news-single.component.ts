import {Component, OnInit} from '@angular/core';
import {NewsModel} from "../../../shared/model/news/news.model";
import {ActivatedRoute, Router} from "@angular/router";
import {NewsService} from "../../../core/news/news.service";
import {CommentsService} from "../../../core/comments/comments.service";
import {CommentsModel} from "../../../shared/model/comments/comments.model";

@Component({
    selector: 'smart-news-single',
    templateUrl: './news-single.component.html',
    styleUrls: ['./news-single.component.css']
})
export class NewsSingleComponent implements OnInit {
    newsModel: NewsModel = new NewsModel();
    commentModels: CommentsModel[];
    commentsModel: CommentsModel = new CommentsModel();
    date = new Date();

    constructor(private route: ActivatedRoute,
                private service: NewsService,
                private  commentsService: CommentsService) {
    }

    ngOnInit() {
        if (this.route.params != null) {
            const id = this.route.snapshot.params.id;
            // console.log("---" + id);
            this.service.getNews(id).subscribe((res: any) => {
                this.newsModel = res;
            });
        }

        this.commentsService.getComments().subscribe(data => {
            this.commentModels = data;
        })
    }

    onSubmit(commentsForm) {
      // console.log(this.newsModel.id);
        this.commentsModel.postDate= this.date;
        this.commentsModel.employeeId =1;
        this.commentsModel.newsId = this.newsModel.id;
        this.commentsService.saveComments(this.commentsModel).subscribe(data =>{
        });
      this.commentsService.getComments().subscribe(data => {
        this.commentModels = data;
      })
    }


}
