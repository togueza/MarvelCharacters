import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MarvelListComponent } from './components/marvel-list/marvel-list.component';
import { MarvelDetailsComponent } from './components/marvel-details/marvel-details.component';
import { AddMarvelComponent } from './components/add-marvel/add-marvel.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },
  { path: 'tutorials', component: MarvelListComponent },
  { path: 'tutorials/:id', component: MarvelDetailsComponent },
  { path: 'add', component: AddMarvelComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
