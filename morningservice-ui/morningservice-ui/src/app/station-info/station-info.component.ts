import { Component } from '@angular/core';
import { IStationInfo } from './station-info';
import { StationInfoService } from './station-info.service';

@Component({
  selector: 'station-info',
  templateUrl: './station-info.component.html',
  styleUrls: ['./station-info.component.css']
})
export class StationInfoComponent {
  constructor(private _stationInfoService: StationInfoService) {};
  title :string = 'station-info';
  stationInfo :IStationInfo;

  /*constructor(stationInfoService: StationInfoService) {
    this._stationInfoService = stationInfoService;
  }*/

  ngOnInit(): void {
    this.stationInfo = this._stationInfoService.getStationInfo();
  }
}
