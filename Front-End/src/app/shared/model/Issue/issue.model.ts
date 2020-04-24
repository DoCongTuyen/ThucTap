import {ProjectModel} from "../project/project.model";
import {StatusModel} from "../status/status.model";

export class IssueModel{
    selected: boolean;
    constructor(){}
    public id?: number;
    public name?: string;
    public startDate?: Date;
    public endDate?: Date;
    public dueDate?: string;
    public donePercent?: number;
    public priority?: string;
    public reason?: string;
    public type?: string;
    public description?: string;
    public projectId?: number;
    public statusId?: number;

}
