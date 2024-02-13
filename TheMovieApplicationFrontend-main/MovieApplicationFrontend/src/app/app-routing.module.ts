import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthComponent } from './auth/auth.component';
import { AppComponent } from './app.component';
import { UserPageComponent } from './user-page/user-page.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { CardComponent } from './card/card.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';

const routes: Routes = [
  {
    path: "",
    component: CardComponent
  },
  {
    path: "auth/login",
    component: LoginComponent
  },
  {
    path: "register",
    component: RegisterComponent
  },
  {
    path: "auth",
    component: AuthComponent
  },
  {
    path: "user/:emailId",
    component: UserPageComponent
  },
  {
    path: "admin-profile",
    component: AdminDashboardComponent
  },
  {
    path: "playlist",
    component: PlaylistComponent
  },
  {
    path: "bookmark",
    component: BookmarkComponent
  },
  {
    path: "user-profile",
    component: UserDashboardComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
