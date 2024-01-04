import { Component, OnInit } from '@angular/core';
import { WalletServiceService } from '../Services/wallet-service.service';
import { wallet } from '../../../wallet';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  constructor(private walletService:WalletServiceService){}
  id!:number;
  user:wallet=new wallet();
  ngOnInit(): void {
    
  }

  flag:boolean=false;
  onSubmit(){
    this.getUser();
  }

  getUser(){
    this.flag=!this.flag;
    this.walletService.getUser(this.id,"user").subscribe(data=>{
      this.user=data;
      console.log(data);
      
    });
  }
} 
