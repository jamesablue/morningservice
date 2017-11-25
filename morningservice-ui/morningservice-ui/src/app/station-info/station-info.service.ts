import { Injectable } from '@angular/core';
import { IStationInfo } from './station-info';

@Injectable()
export class StationInfoService {

    getStationInfo(): IStationInfo {
        return {
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
          }
    }
}