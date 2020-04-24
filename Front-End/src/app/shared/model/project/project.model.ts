import {StatusModel} from "../status/status.model";

export class ProjectModel extends StatusModel{
    public id?: number;
    public name?: string;
    statusId?: StatusModel;
}
