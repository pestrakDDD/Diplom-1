import { FeedModel } from './../../../models/Feed';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-create-edit',
  templateUrl: './create-edit.component.html',
  styleUrls: ['./create-edit.component.scss']
})
export class CreateEditComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<CreateEditComponent>, @Inject(MAT_DIALOG_DATA) public data: FeedModel) { }

  ngOnInit(): void {
  }

}
