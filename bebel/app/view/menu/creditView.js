define(["jquery","underscore","app/utils/utils","text!app/template/menu/popup/credit.html"],function(b,d,f,e){return function(c){this.init=function(a){this.el="#credit-popup";this.Textes=a;this.render()};this.render=function(){d.templateSettings.variable="data";var a=d.template(e),c={text:this.Textes};b(this.el).html(a(c));this.makeEvents()};this.makeEvents=function(){var a=this;b(this.el).click(function(){b(a.el).hide("slow")})};this.show=function(){b(this.el).show("slow")};this.init(c)}});