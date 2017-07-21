
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment"

@Injectable()
export class MessageService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = "http://" + environment.host + "/message";
  }

  fetchMessage() {
    return this.http.get(this.url);
  }
}
