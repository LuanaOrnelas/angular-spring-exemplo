import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpModule} from '@angular/http';

import {ConfigService} from './services/config.service';
import {PessoaService} from './services/pessoa.service';
import {MenuComponent} from './menu/menu.component';
import {HomeComponent} from './home/home.component';
import {ConsultaComponent} from './pessoa/consulta/consulta.component';
import {CadastroComponent} from './pessoa/cadastro/cadastro.component';
import {FormsModule} from '@angular/forms';
import {routing} from '../app.routes';



@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ConsultaComponent,
    CadastroComponent

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    routing
  ],
  providers: [ConfigService, PessoaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
