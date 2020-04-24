import {Component, Input, OnInit} from '@angular/core';
import {EmployeeModel} from "../../../shared/model/employee/employee.model";
import {EmployeeService} from "../../../core/employee/employee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";


@Component({
    selector: 'smart-confirm-delete-user',
    templateUrl: './confirm-delete-user.component.html',
    styleUrls: ['./confirm-delete-user.component.scss']
})
export class ConfirmDeleteUserComponent implements OnInit {
    employeeModel: EmployeeModel = new EmployeeModel();
    employeeModels: EmployeeModel[];
    updateForm : FormGroup;
    fileList: any;
    private currentFileUpload: any;

    constructor(private employeeService: EmployeeService,
                private route: ActivatedRoute,
                private rt: Router) {
        this.updateForm = new FormGroup({
            id: new FormControl(),
            userName: new FormControl(),
            password: new FormControl(),
            imgUrl: new FormControl(),
            lastAccess: new FormControl(),
            fullName: new FormControl(),
            createdDate: new FormControl(),
            email: new FormControl(),
            phoneNumber: new FormControl(),
            skypeAccount: new FormControl(),
            userType: new FormControl(),
            address: new FormControl(),
            university: new FormControl(),
            graduatedYear: new FormControl(),
            isLeader: new FormControl(),
            isManager: new FormControl(),
            isActived: new FormControl(),
            positionId: new FormControl(),
            teamId: new FormControl(),
            departmentId: new FormControl(),
            birthDay: new FormControl()
        });
    }
    updateEmployee(){
        this.employeeService.updateEmployee(this.employeeModel).subscribe(data =>{
                    this.rt.navigate(['/quan-ly-user/user-mng'])
        })
        this.upload();
        this.ngOnInit();
    }
    ngOnInit() {
        if (this.route.params != null) {

            const id = this.route.snapshot.params.id;
            this.employeeService.getEmployeeById(id).subscribe(data => {
                this.employeeModel = data;
            })

        }
    }
    xulyFile(event) {
        this.fileList = event.target.files;
        const file: File = this.fileList[0];
        this.employeeModel.imgUrl = file.name;
    }

    public onSubmit() {
        // this.activeModal.dismiss();
    }
    upload() {
        this.currentFileUpload = this.fileList.item(0);
        this.employeeService.doUpload(this.currentFileUpload).subscribe(event => {
                // console.log(this.currentFileUpload);
                this.fileList = undefined;

            }
        );
    }
    deleteUser(employee: EmployeeModel){
        this.employeeService.deleteEmployee(employee).subscribe(data =>{
            this.employeeModels = this.employeeModels.filter(u => u !== employee);
        });
        this.rt.navigate(['/quan-ly-user/user-mng']);
    }
    // public cancel() {
    //     this.activeModal.dismiss();
    // }

}
