import { Component, OnInit } from '@angular/core';
import { VdpService } from "../service/vdp.service";

@Component({
  selector: 'app-vdp',
  templateUrl: './vdp.component.html',
  styleUrls: ['./vdp.component.scss']
})
export class VdpComponent implements OnInit {
  response: string | null

  constructor(private vdpService: VdpService) {
    this.response = ''
  }

  ngOnInit(): void {
  }

  getVdpHelloWorld(): void {
    this.vdpService.getVdpHelloWorld().subscribe(data => {
      this.response = JSON.stringify(data);
    });
  }

}
