import { Injectable } from '@angular/core';
import { IStationInfo } from './station-info';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import { HttpErrorResponse } from '@angular/common/http/src/response';

@Injectable()
export class StationInfoService {
    private _stationUrl = 'http://localhost:8080/getStationInfoRaw/';

    constructor(private _http: HttpClient) {}

    getStationInfo(stationCode: string): Observable<IStationInfo> {
        return this._http.get<IStationInfo>(this._stationUrl + stationCode)
            .do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
        /*return {
            "Trains": [{
              "Car": "6",
              "Destination": "Brnch Av",
              "DestinationCode": "F11",
              "DestinationName": "Branch Ave",
              "Group": "2",
              "Line": "GR",
              "LocationCode": "E09",
              "LocationName": "College Park-U of Md",
              "Min": "3"
            }, {
              "Car": "6",
              "Destination": "Grnbelt",
              "DestinationCode": "E10",
              "DestinationName": "Greenbelt",
              "Group": "1",
              "Line": "GR",
              "LocationCode": "E09",
              "LocationName": "College Park-U of Md",
              "Min": "11"
            }, {
              "Car": "-",
              "Destination": "Brnch Av",
              "DestinationCode": "F11",
              "DestinationName": "Branch Ave",
              "Group": "2",
              "Line": "GR",
              "LocationCode": "E09",
              "LocationName": "College Park-U of Md",
              "Min": "23"
            }, {
              "Car": "8",
              "Destination": "Grnbelt",
              "DestinationCode": "E10",
              "DestinationName": "Greenbelt",
              "Group": "1",
              "Line": "GR",
              "LocationCode": "E09",
              "LocationName": "College Park-U of Md",
              "Min": "28"
            }]
          }*/
    }

    private handleError(err: HttpErrorResponse) {
        console.log(err.message);
        return Observable.throw(err.message);
    }
}