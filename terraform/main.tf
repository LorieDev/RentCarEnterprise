provider "aws" {
  region = "us-east-2"
}

# 🔐 Security Group
resource "aws_security_group" "rentcar_sg" {
  name        = "rentcar-sg"
  description = "Allow SSH and HTTP"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# 🖥️ EC2 Instance
resource "aws_instance" "rentcar_server" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t3.micro"

  key_name = "rentcar"   # 👈 nap kreye sa nan AWS

  vpc_security_group_ids = [aws_security_group.rentcar_sg.id]

  tags = {
    Name = "RentCar-Server"
  }
}