import {Component, Input, OnInit} from '@angular/core';
import {EmployeeService} from "../../../core/employee/employee.service";
import {EmployeeModel} from "../../../shared/model/employee/employee.model";
import {Router} from "@angular/router";

@Component({
    selector: 'smart-insert-update-user',
    templateUrl: './insert-update-user.component.html',
    styleUrls: ['./insert-update-user.component.scss']
})
export class InsertUpdateUserComponent implements OnInit {
    // @Input() actionType: any;
    // @Input() selectedItem: any;
    // title: any = '';
    // khois: any = [{id: 1, name: 'Ngân Hàng'}, {id: 2, name: 'Chăm sóc KH'}];
    // donvi: any = [{id: 1, name: 'SeABank'}];
    // status: any = [{id: 1, value: 1, name: 'Hiệu lực'}, {id: 2, value: 0, name: 'Không hiệu lực'}];
    // moment = moment;
    // submitted: boolean =  false;

    employeeModel: EmployeeModel = new EmployeeModel();
    employeeModels: EmployeeModel[];
    currentFileUpload: any;
    fileList: any;
    constructor(private employeeService: EmployeeService,
                private router: Router) {
    }
    onSubmit(employeeForm){
        this.employeeModel.isLeader=1;
        this.employeeModel.isManager=1;
        this.employeeModel.isActived=1;
        this.employeeModel.positionId=1;
        this.employeeModel.departmentId=1;
        this.employeeModel.teamId=1;
        this.employeeModel.createdDate= new Date();
        this.employeeModel.lastAccess = new Date();
        this.employeeService.addEmployee(this.employeeModel).subscribe(data =>{
            this.router.navigate(['/quan-ly-user/user-mng'])
        })
        this.upload();
    }
    xulyFile(event) {
        this.fileList = event.target.files;
        const file: File = this.fileList[0];
        this.employeeModel.imgUrl = file.name;
    }
    upload() {
        this.currentFileUpload = this.fileList.item(0);
        this.employeeService.doUpload(this.currentFileUpload).subscribe(event => {
                // console.log(this.currentFileUpload);
                this.fileList = undefined;

            }
        );

    }






    // addUpdateForm = this.fb.group({
    //     user_name: ['', Validators.required],
    //     password: ['', Validators.required],
    //     reinput_password: ['', Validators.required],
    //     full_name: ['', Validators.required],
    //     khoi: [null, Validators.required],
    //     don_vi: [null, Validators.required],
    //     status: [1, []]
    // });

    ngOnInit() {
        // if ('ADD' === this.actionType) {
        //     this.title = 'Thêm mới User';
        // } else {
        //     this.title = 'Cập nhật thông tin User';
        // }
    }

    // get f() {
    //     return this.addUpdateForm.controls;
    // }
    //
    // public onSubmit() {
    //     // this.submitted = true;
    //     // if (this.addUpdateForm.invalid) {
    //     //     return;
    //     // }
    //     // this.submitted = false;
    //     console.log('----- dong man hinh!!');
    //     this.activeModal.dismiss();
    // }
    //
    // public cancel() {
    //     this.activeModal.dismiss();
    // }

}
