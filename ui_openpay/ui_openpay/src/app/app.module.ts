import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddMarvelComponent } from './components/add-marvel/add-marvel.component';
import { MarvelDetailsComponent } from './components/marvel-details/marvel-details.component';
import { MarvelListComponent } from './components/marvel-list/marvel-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddMarvelComponent,
    MarvelDetailsComponent,
    MarvelListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
