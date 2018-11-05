import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {ImageServiceService} from '../../../shared/services/images/image-service.service';
import {HttpEventType, HttpResponse} from '@angular/common/http';
import {UserShowService} from '../../../shared/services/user-show.service';

@Component({
  selector: 'app-dialog-change-photo',
  templateUrl: './dialog-change-photo.component.html',
  styleUrls: ['./dialog-change-photo.component.scss']
})
export class DialogChangePhotoComponent implements OnInit {

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  result: string = '';
  constructor(
    public dialogRef: MatDialogRef<DialogChangePhotoComponent>,
    private uploadService: ImageServiceService,
    private userShow: UserShowService
   ) {}

  ngOnInit() {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
  selectFile(event) {
    this.selectedFiles = event.target.files;
    // console.log(event.target.files);
    // this.result = event.target.files.length;
  }

  upload() {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    if (this.userShow.userId)
    this.uploadService.pushFileToUserStorage(this.currentFileUpload,this.userShow.userId).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.onNoClick();
      }
    });

    this.selectedFiles = undefined;
  }
}
