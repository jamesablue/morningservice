export interface IStationInfo {
    Trains: ITrain[];
}

export interface ITrain {
    Car: string;
    Destination: string;
    DestinationCode: string;
    DestinationName: string;
    Group: string;
    Line: string;
    LocationCode: string;
    LocationName: string;
    Min: string;
}