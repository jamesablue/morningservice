import { Component } from '@angular/core';
import { IStationInfo } from './station-info';
import { StationInfoService } from './station-info.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  //selector: 'station-info',
  templateUrl: './station-info.component.html',
  styleUrls: ['./station-info.component.css']
})
export class StationInfoComponent {
  constructor(private _stationInfoService: StationInfoService,
    private _route: ActivatedRoute) {};
  title :string = 'station-info';
  stationInfo :IStationInfo;
  errorMessage: string;
  stationCode: string =  this._route.snapshot.paramMap.get('code');

  /*constructor(stationInfoService: StationInfoService) {
    this._stationInfoService = stationInfoService;
  }*/

  ngOnInit(): void {
    //this.stationInfo = this._stationInfoService.getStationInfo();
    console.log("StationCode is: " + this.stationCode);
    this._stationInfoService.getStationInfo(this.stationCode)
      .subscribe(
        stationInfo => this.stationInfo = stationInfo,
        error => this.errorMessage = <any>error
      );
  }
}
