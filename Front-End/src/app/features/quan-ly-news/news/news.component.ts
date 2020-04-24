import { Component, OnInit } from '@angular/core';
import {NewsService} from "../../../core/news/news.service";
import {NewsModel} from "../../../shared/model/news/news.model";

@Component({
  selector: 'smart-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  newsModels: NewsModel[];
  newsModel: NewsModel = new NewsModel();
  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsService.getAll().subscribe(data =>{
      this.newsModels = data;
    })
  }
  onView(id: number){
    this.newsService.getNews(id).subscribe(data =>{
      this.newsModel = data;
    })
  }

}
