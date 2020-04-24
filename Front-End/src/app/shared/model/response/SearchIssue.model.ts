import {BaseModel} from "../base.model";

export class SearchIssueModel extends BaseModel {
    id: any;
    name: string;
    startDate: any;
    endDate:any;
    dueDate: number;
    donePercent: number;
    priority: string;
    reason: string;
    type: string;
    description: string;
    projectId: number;
    statusId: number;

}
