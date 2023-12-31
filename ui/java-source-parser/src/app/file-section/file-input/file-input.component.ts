import { Component } from '@angular/core';
import { Input } from '@angular/core';

@Component({
  selector: 'app-file-input',
  templateUrl: './file-input.component.html',
  styleUrls: ['./file-input.component.css'],
})
export class FileInputComponent {
  @Input() title: string;

  @Input() fileString: string;

  constructor() {
    this.title = '';
    this.fileString = '';
  }

  setTextContent() {}
}
