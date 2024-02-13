import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { MatCardModule } from '@angular/material/card';
import { MatPaginatorModule } from '@angular/material/paginator';
import { HttpClientModule } from '@angular/common/http';
import { AuthComponent } from './auth/auth.component';
import { CardComponent } from './card/card.component';
import { MatDividerModule } from '@angular/material/divider';
import { UserPageComponent } from './user-page/user-page.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { BookmarkComponent } from './bookmark/bookmark.component';
import { MatDialogModule } from '@angular/material/dialog';
import { DialogForPlaylistComponent } from './dialog-for-playlist/dialog-for-playlist.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { FormsModule } from '@angular/forms';
import { MovieComponent } from './movie/movie.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastsComponent } from './toasts/toasts.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AdminDashboardComponent,
    AuthComponent,
    CardComponent,
    UserPageComponent,
    PlaylistComponent,
    BookmarkComponent,
    DialogForPlaylistComponent,
    UserDashboardComponent,
    MovieComponent,
    HomeComponent,
    ToastsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatPaginatorModule,
    HttpClientModule,
    MatDividerModule,
    MatDialogModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
