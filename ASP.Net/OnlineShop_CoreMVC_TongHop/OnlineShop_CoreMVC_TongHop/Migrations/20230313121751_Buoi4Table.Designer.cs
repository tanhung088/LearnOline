﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using OnlineShop_CoreMVC_TongHop.Models;

#nullable disable

namespace OnlineShop_CoreMVC_TongHop.Migrations
{
    [DbContext(typeof(DatabaseContext))]
    [Migration("20230313121751_Buoi4Table")]
    partial class Buoi4Table
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.9")
                .HasAnnotation("Relational:MaxIdentifierLength", 128);

            SqlServerModelBuilderExtensions.UseIdentityColumns(modelBuilder, 1L, 1);

            modelBuilder.Entity("OnlineShop_CoreMVC_TongHop.Models.Product", b =>
                {
                    b.Property<int?>("Pro_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int?>("Pro_Id"), 1L, 1);

                    b.Property<int?>("Discount")
                        .IsRequired()
                        .HasColumnType("int");

                    b.Property<string>("Pro_Des")
                        .IsRequired()
                        .HasColumnType("nvarchar(max)");

                    b.Property<string>("Pro_Name")
                        .IsRequired()
                        .HasMaxLength(40)
                        .HasColumnType("nvarchar(40)");

                    b.Property<int?>("Quantity")
                        .IsRequired()
                        .HasColumnType("int");

                    b.Property<float?>("UnitPrice")
                        .IsRequired()
                        .HasColumnType("real");

                    b.HasKey("Pro_Id");

                    b.ToTable("Product");
                });

            modelBuilder.Entity("OnlineShop_CoreMVC_TongHop.Models.User", b =>
                {
                    b.Property<int>("User_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    SqlServerPropertyBuilderExtensions.UseIdentityColumn(b.Property<int>("User_Id"), 1L, 1);

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasMaxLength(150)
                        .HasColumnType("nvarchar(150)");

                    b.Property<string>("Password")
                        .IsRequired()
                        .HasMaxLength(150)
                        .HasColumnType("nvarchar(150)");

                    b.Property<bool>("Role")
                        .HasColumnType("bit");

                    b.Property<string>("User_Name")
                        .IsRequired()
                        .HasMaxLength(50)
                        .HasColumnType("nvarchar(50)");

                    b.HasKey("User_Id");

                    b.ToTable("User");
                });
#pragma warning restore 612, 618
        }
    }
}
