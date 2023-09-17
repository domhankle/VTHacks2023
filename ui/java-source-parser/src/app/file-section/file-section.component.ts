import { Component, QueryList, ViewChildren, Inject } from '@angular/core';
import { FileInputComponent } from './file-input/file-input.component';
import { EndpointService } from '../endpoint.service';

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
  similarityPercentageString: string = '0';

  constructor(
    @Inject(EndpointService) private endpointService: EndpointService
  ) {}

  public onCompareClick(): void {
    this.similarityPercentage = 0.0;
    let fileStrings: string[] = [];
    this.fileInputComponents?.forEach((component) => {
      component.setTextContent();
      fileStrings.push(component.fileString);
    });

    this.endpointService
      .putFileStrings(fileStrings.at(0)!, fileStrings.at(1)!)
      .subscribe(
        (response) => {
          this.endpointService.getSimilarity().subscribe((response) => {
            console.log(response);
            this.similarityPercentage = response * 100;
            this.similarityPercentageString =
              this.similarityPercentage.toFixed(2);
          });
        },
        (error) => {
          console.log('ERROR YOU SUCK');
        }
      );
  }
}
