import { Component } from '@angular/core';

@Component({
  selector: 'app-file-section',
  templateUrl: './file-section.component.html',
  styleUrls: ['./file-section.component.css'],
})
export class FileSectionComponent {
  title1: string = 'Paste File #1 Here';
  title2: string = 'Paste File #2 Here';

  similarityPercentage: number = 0;
}
