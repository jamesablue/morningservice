import { Component } from '@angular/core';
import { StationInfoService } from './station-info/station-info.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [StationInfoService]
})
export class AppComponent {
  title = 'app';
}
