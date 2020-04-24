import {Component, OnInit, ChangeDetectionStrategy} from '@angular/core';
import {dl_quan_ly_user} from './dl-quan-ly-user';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {InsertUpdateUserComponent} from './insert-update-user/insert-update-user.component';
import {ConfirmDeleteUserComponent} from './confirm-delete-user/confirm-delete-user.component';
import {EmployeeService} from "../../core/employee/employee.service";
import {EmployeeModel} from "../../shared/model/employee/employee.model";

@Component({
    selector: 'smart-user-mng',
    templateUrl: './user-mng.component.html'
})
export class UserMngComponent implements OnInit {

    employeeModels: EmployeeModel[];
    employeeModel: EmployeeModel = new EmployeeModel();
    constructor(public modal: NgbModal,
                private emloyeeService: EmployeeService) {
    }

    // ADD = 'ADD';
    // UPDATE = 'UPDATE';
    // users: any[] = dl_quan_ly_user;
    // status: any = [{id: 1, value: 1, name: 'Hoạt động'}, {id: 2, value: 0, name: 'Không hoạt động'}];
    //
    // selectedItems = [];

    onUpdate(id: number) {
        this.emloyeeService.getEmployeeById(id).subscribe(data => {
            this.employeeModel = data;
        });
    }
    ngOnInit() {
        this.emloyeeService.getEmployees().subscribe(data =>{
            this.employeeModels= data;
        })
    }

    // loadUsers() {
    //     this.emloyeeService.getEmployees().subscribe(data =>{
    //             this.employeeModels= data;
    //             console.log(data);
    //     })
    // }
    // add() {
    //     const modalRef = this.modal.open(InsertUpdateUserComponent, {size: 'lg'});
    //     modalRef.componentInstance.actionType = this.ADD;
    // }
    //
    // doEdit(event: MouseEvent, dataItem) {
    //     event.preventDefault();
    //     const modalRef = this.modal.open(InsertUpdateUserComponent, {size: 'lg'});
    //     modalRef.componentInstance.actionType = this.UPDATE;
    //     modalRef.componentInstance.selectedItem = dataItem;
    // }
    //
    // doDelete(event: MouseEvent, dataItem) {
    //     event.preventDefault();
    //     const modalRef = this.modal.open(ConfirmDeleteUserComponent, {size: 'sm'});
    //     modalRef.componentInstance.selectedItem = dataItem;
    // }
    //
    // doSearch() {
    //
    // }

}
