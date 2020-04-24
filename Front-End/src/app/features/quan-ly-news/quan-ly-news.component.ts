import {Component, OnInit} from '@angular/core';
import {NewsModel} from "../../shared/model/news/news.model";
import {NewsService} from "../../core/news/news.service";
import {Router} from "@angular/router";

@Component({
    selector: 'smart-quan-ly-news',
    templateUrl: './quan-ly-news.component.html',
    styleUrls: ['./quan-ly-news.component.css']
})
export class QuanLyNewsComponent implements OnInit {
    fileList: FileList;
    date = new Date();
    newsModels: NewsModel[];
    currentFileUpload: File;
    newsModel: NewsModel = new NewsModel();

    constructor(private newsService: NewsService,
                private router: Router) {
    }

    ngOnInit() {
    }

    onSubmit(newsForm) {
        this.newsModel.ngayDang=this.date;
        this.newsService.create(this.newsModel).subscribe(data => {
            // this.router.navigate(['/news'])
        })

        this.upload();
        this.router.navigate(["/news"]);
        this.ngOnInit();
    }

    xulyFile(event) {
        this.fileList = event.target.files;
        const file: File = this.fileList[0];
        this.newsModel.imgUrl = file.name;
        console.log(this.newsModel.imgUrl);
    }

    upload() {
        this.currentFileUpload = this.fileList.item(0);
        this.newsService.doUpload(this.currentFileUpload).subscribe(event => {
                // console.log(event);
                this.fileList = undefined;

            }
        );

    }
}
