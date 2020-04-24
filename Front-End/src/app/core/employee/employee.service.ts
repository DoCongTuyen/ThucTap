import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {EmployeeModel} from "../../shared/model/employee/employee.model";
import {AppConfigService} from "../../app-config.service";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient,
              private config: AppConfigService) { }

  getEmployees(): Observable<EmployeeModel[]>{
    return this.http.get<EmployeeModel[]>(`${this.config.getAPIEndPoint()}/employee`);
  }
  getEmployeeById(id: number): Observable<any>{
    return this.http.get(`${this.config.getAPIEndPoint()}/employee/find-one/${id}`);
  }
  updateEmployee(employeeModel: EmployeeModel){
    return this.http.put(`${this.config.getAPIEndPoint()}/employee/update`,employeeModel);
  }
  addEmployee(employee: EmployeeModel){
    return this.http.post<EmployeeModel>(`${this.config.getAPIEndPoint()}/employee/create`,employee);
  }
  doUpload(file: File): Observable<HttpEvent<{}>> {
    const data: FormData = new FormData(); // k can submit form, dung ajax de gui du lieu form
    data.append('file', file); // Phương thức append cho phép chúng ta chèn thêm một cặp key => value vào trong FormData
    const newRequest = new HttpRequest('POST', 'http://localhost:8082/api/upload', data, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(newRequest);
  }
  deleteEmployee(employeeModel: EmployeeModel){
    return this.http.delete(`${this.config.getAPIEndPoint()}/employee/delete/${employeeModel.id}`);
  }
}
