import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxSpinnerModule} from "ngx-spinner";
import {RouterModule} from "@angular/router";
import {LoginComponent} from "../login/login.component";
import {LoginRouteAccessService} from "../login/login-route-access-service";
import {RegisterComponent} from "./register.component";

@NgModule({
  declarations: [RegisterComponent],
  imports: [
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    NgxSpinnerModule,
    RouterModule.forChild([
      {
        path: '',
        component: RegisterComponent,
        canActivate: []
      }
    ])
  ]
})
export class RegisterModule { }
