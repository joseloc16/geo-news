import { Routes } from '@angular/router';
import {TouristInfoComponent} from './components/tourist-info/tourist-info.component';
import {WeatherForecastComponent} from './components/weather-forecast/weather-forecast.component';
import {AverageTemperatureComponent} from './components/average-temperature/average-temperature.component';

export const routes: Routes = [
  {path: '', component: TouristInfoComponent},
  {path: 'forecast', component: WeatherForecastComponent},
  {path: 'average', component: AverageTemperatureComponent},
];
