define(["jquery","underscore","app/utils/utils","app/data/stages.js","text!app/template/menu/popup/load.html"],function(a,e,f,g,h){return function(k,l){this.init=function(a,b){this.el="#load-popup";this.parent=a;this.Textes=b;this.render()};this.render=function(){e.templateSettings.variable="data";var c=e.template(h),b=void 0!=window.localStorage.getItem(f.name),b={text:this.Textes,saveExist:b};a(this.el).html(c(b));this.makeEvents()};this.makeEvents=function(){var c=this;a(this.el).find(".close").click(function(){a(c.el).hide("slow")});
a(this.el).find("#loadSave").click(function(){c.parent.loadGame()});a(this.el).find("#loadCode").click(function(){var b=a("#code").val();if(!b)return c.error();try{var d=JSON.parse(f.decode(b))}catch(e){return c.error()}if(!d||!d.lieu||!d.stage||0==g.get(d.lieu+d.stage).length)return c.error();c.parent.loadGame(b)})};this.error=function(){a(a("#code").parent()).addClass("has-error");a("#code").attr("placeholder",this.Textes.get("codeError"));a("#code").val("")};this.show=function(){a(this.el).show("slow")};
this.init(k,l)}});