import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainComponent} from './layout/main/main.component';
import {LayoutModule} from './layout/layout.module';
import {errorRoute} from './layout/error/error.route';
import {UserRouteAccessService} from './core/auth/user-route-access-service';
import {NewsComponent} from "./features/quan-ly-news/news/news.component";
import {NewsSingleComponent} from "./features/quan-ly-news/news-single/news-single.component";

// @ts-ignore
const routes: Routes = [

    {
        path: '',
        component: MainComponent,
        children: [
            {path: '', redirectTo: 'news', pathMatch: 'full'},
            {
                path: 'news', component: NewsComponent,
                data: {
                    breadcrumbs: ['News', '']
                }
            },
            {path: 'news/details/:id', component: NewsSingleComponent},
            {path: 'intel', loadChildren: () => import('./features/about/about.module').then(m => m.AboutModule)},
            {path: 'info', loadChildren: () => import('./features/info/info.module').then(m => m.InfoModule)},
            {
                path: 'examples',
                loadChildren: () => import('./examples/examples.module').then(m => m.ExamplesModule),
                // canActivate: [UserRouteAccessService],
                // data: {
                //     authorities: ['ROLE_ADMIN']
                // }
            },
            {
                path: 'quan-ly-user',
                loadChildren: () => import('./features/quan-ly-user/user-mng.module').then(m => m.UserMngModule),
                // canActivate: [UserRouteAccessService],
                // data: {
                //     authorities: ['ROLE_ADMIN']
                // }
            },
            {
                path: 'quan-ly-issue',
                loadChildren: () => import('./features/quan-ly-issue/quan-ly-issue.module').then(m => m.QuanLyIssueModule),
                // canActivate: [UserRouteAccessService],
                // data: {
                //     authorities: ['ROLE_ADMIN']
                // }
            },
            {
                path: 'quan-ly-news',
                loadChildren: () => import('./features/quan-ly-news/quan-ly-news.module').then(m => m.QuanLyNewsModule),
                // canActivate: [UserRouteAccessService],
                // data: {
                //     authorities: ['ROLE_ADMIN']
                // }
            }


        ]
    },
    {
        path: 'login',
        loadChildren: () => import('./core/login/login.module').then(m => m.LoginModule),
    },
    {
        path: 'register',
        loadChildren: () => import('./core/register/register.module').then(m => m.RegisterModule),
    },
    {
        path: 'login-alt',
        loadChildren: () => import('./core/login_alt/login-alt.module').then(m => m.LoginAltModule),
    },
    ...errorRoute
];

@NgModule({
    imports: [LayoutModule, RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
