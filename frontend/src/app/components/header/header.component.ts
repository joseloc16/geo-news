import {Component, EventEmitter, Input, Output} from '@angular/core';
import { MatToolbar } from '@angular/material/toolbar';
import { MatIconButton } from '@angular/material/button';
import { MatIcon } from '@angular/material/icon';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-header',
  standalone:true,
  imports: [
    MatToolbar,
    MatIconButton,
    MatIcon,
    NgIf
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  @Input() sidenavOpened = false;
  @Output() toggleSidenav = new EventEmitter<void>();
}
