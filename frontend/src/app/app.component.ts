import {Component, OnInit} from '@angular/core';
import {MessageService} from "./message.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  message: string;
  version: string;

  constructor(private messageService: MessageService) {}

  ngOnInit(): void {
    this.messageService.fetchMessage().subscribe(
      (response) => {
        this.message = response['text'];
        this.version = response['version'];
      },
      (error) => {
        console.log("An error occurred." + error);
      }
    );
  }
}
