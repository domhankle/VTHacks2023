import { Component, QueryList, ViewChildren } from '@angular/core';
import { FileInputComponent } from './file-input/file-input.component';

@Component({
  selector: 'app-file-section',
  templateUrl: './file-section.component.html',
  styleUrls: ['./file-section.component.css'],
})
export class FileSectionComponent {
  @ViewChildren(FileInputComponent)
  fileInputComponents?: QueryList<FileInputComponent>;
  title1: string = 'Paste File #1 Here';
  title2: string = 'Paste File #2 Here';
  similarityPercentage: number = 0;

  public onCompareClick(): void {
    this.fileInputComponents?.forEach((component) => {
      component.setTextContent();
    });
  }
}
