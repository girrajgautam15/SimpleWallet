import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { wallet } from '../../../wallet';
import { FormsModule } from '@angular/forms';
import { WalletServiceService } from '../Services/wallet-service.service';


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  constructor(private walletService:WalletServiceService){}
  
  w:wallet=new wallet();
  onSubmit(){
    this.w.amount=0;
    console.log(this.w);
    this.walletService.addUser(this.w,).subscribe(data=>{
      console.log(data);
    },error=>console.log(error));
  }
}
  
