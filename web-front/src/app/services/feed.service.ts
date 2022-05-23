import { FeedModel } from './../models/Feed';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  constructor(private http: HttpClient) { }

  getAllFeed(): Observable<FeedModel[]>{
    return this.http.get<FeedModel[]>('api/api/feed/all');
  }

  getFeedById(id: number): Observable<FeedModel>{
    return this.http.get<FeedModel>(`api/api/feed/${id}`);
  }

  save(feed: FeedModel): Observable<FeedModel> {
    return this.http.post<FeedModel>('api/api/feed', feed);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`api/api/feed/${id}`);
  }
}
