import { CreateEditComponent } from './create-edit/create-edit.component';
import { FeedModel } from './../../models/Feed';
import { Component, OnInit } from '@angular/core';
import { FeedService } from 'src/app/services/feed.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})
export class FeedComponent implements OnInit {

  data: FeedModel[] = [];
  isDelete: boolean = false;

  constructor(private feedService: FeedService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.feedService.getAllFeed().subscribe(result => {
      this.data = result;
    });
  }

  deleteId(id: number | null): void {
    this.feedService.delete(id).subscribe(res => {
      this.ngOnInit();
    })
  }

  createOrEdit(id: number | null): void {
    if (this.isDelete) return;
    if (id == null) return;
    this.feedService.getFeedById(id).subscribe(result => {
      const dialogAddingNewFeed = this.dialog.open(CreateEditComponent, {
        width: '800px',
        data: result
        });

        dialogAddingNewFeed.afterClosed().subscribe(res  => {
            if (res != null) {
              this.feedService.save(res).subscribe(resFeed => {
                this.ngOnInit();
              });
            }
        });
    });
  }

  create(): void {
    this.isDelete = true;
    let feed = new FeedModel("Новая заметка", "Описание новой заметки", 0);
    feed.id = null;
    this.feedService.save(feed).subscribe(() => {
      this.ngOnInit();
      this.isDelete = false;
    });
  }

}
