var dp={sh:{Toolbar:{},Utils:{},RegexLib:{},Brushes:{},Strings:{AboutDialog:'<html><head><title>About...</title></head><body class="dp-about"><table cellspacing="0"><tr><td class="copy"><p class="title">dp.SyntaxHighlighter</div><div class="para">Version: {V}</p><p><a href="http://www.dreamprojections.com/syntaxhighlighter/?ref=about" target="_blank">http://www.dreamprojections.com/syntaxhighlighter</a></p>&copy;2004-2007 Alex Gorbatchev.</td></tr><tr><td class="footer"><input type="button" class="close" value="OK" onClick="window.close()"/></td></tr></table></body></html>'},ClipboardSwf:null,Version:"1.5.1"}};dp.SyntaxHighlighter=dp.sh,dp.sh.Toolbar.Commands={ExpandSource:{label:"+ expand source",check:function(e){return e.collapse},func:function(e,t){e.parentNode.removeChild(e),t.div.className=t.div.className.replace("collapsed","")}},ViewSource:{label:"view plain",func:function(e,t){var s=dp.sh.Utils.FixForBlogger(t.originalCode).replace(/</g,"&lt;"),i=window.open("","_blank","width=750, height=400, location=0, resizable=1, menubar=0, scrollbars=0");i.document.write('<textarea style="width:99%;height:99%">'+s+"</textarea>"),i.document.close()}},CopyToClipboard:{label:"copy to clipboard",check:function(){return null!=window.clipboardData||null!=dp.sh.ClipboardSwf},func:function(e,t){var s=dp.sh.Utils.FixForBlogger(t.originalCode).replace(/&lt;/g,"<").replace(/&gt;/g,">").replace(/&amp;/g,"&");if(window.clipboardData)window.clipboardData.setData("text",s);else if(null!=dp.sh.ClipboardSwf){var i=t.flashCopier;null==i&&(i=document.createElement("div"),t.flashCopier=i,t.div.appendChild(i)),i.innerHTML='<embed src="'+dp.sh.ClipboardSwf+'" FlashVars="clipboard='+encodeURIComponent(s)+'" width="0" height="0" type="application/x-shockwave-flash"></embed>'}alert("The code is in your clipboard now")}},PrintSource:{label:"print",func:function(e,t){var s=document.createElement("IFRAME"),i=null;s.style.cssText="position:absolute;width:0px;height:0px;left:-500px;top:-500px;",document.body.appendChild(s),i=s.contentWindow.document,dp.sh.Utils.CopyStyles(i,window.document),i.write('<div class="'+t.div.className.replace("collapsed","")+' printing">'+t.div.innerHTML+"</div>"),i.close(),s.contentWindow.focus(),s.contentWindow.print(),alert("Printing..."),document.body.removeChild(s)}},About:{label:"?",func:function(e){var t=window.open("","_blank","dialog,width=300,height=150,scrollbars=0"),s=t.document;dp.sh.Utils.CopyStyles(s,window.document),s.write(dp.sh.Strings.AboutDialog.replace("{V}",dp.sh.Version)),s.close(),t.focus()}}},dp.sh.Toolbar.Create=function(e){var t=document.createElement("DIV");t.className="tools";for(var s in dp.sh.Toolbar.Commands){var i=dp.sh.Toolbar.Commands[s];(null==i.check||i.check(e))&&(t.innerHTML+='<a href="#" onclick="dp.sh.Toolbar.Command(\''+s+"',this);return false;\">"+i.label+"</a>")}return t},dp.sh.Toolbar.Command=function(e,t){for(var s=t;null!=s&&-1==s.className.indexOf("dp-highlighter");)s=s.parentNode;null!=s&&dp.sh.Toolbar.Commands[e].func(t,s.highlighter)},dp.sh.Utils.CopyStyles=function(e,t){for(var s=t.getElementsByTagName("link"),i=0;i<s.length;i++)"stylesheet"==s[i].rel.toLowerCase()&&e.write('<link type="text/css" rel="stylesheet" href="'+s[i].href+'"></link>')},dp.sh.Utils.FixForBlogger=function(e){return 1==dp.sh.isBloggerMode?e.replace(/<br\s*\/?>|&lt;br\s*\/?&gt;/gi,"\n"):e},dp.sh.RegexLib={MultiLineCComments:new RegExp("/\\*[\\s\\S]*?\\*/","gm"),SingleLineCComments:new RegExp("//.*$","gm"),SingleLinePerlComments:new RegExp("#.*$","gm"),DoubleQuotedString:new RegExp('"(?:\\.|(\\\\\\")|[^\\""\\n])*"',"g"),SingleQuotedString:new RegExp("'(?:\\.|(\\\\\\')|[^\\''\\n])*'","g")},dp.sh.Match=function(e,t,s){this.value=e,this.index=t,this.length=e.length,this.css=s},dp.sh.Highlighter=function(){this.noGutter=!1,this.addControls=!0,this.collapse=!1,this.tabsToSpaces=!0,this.wrapColumn=80,this.showColumns=!0},dp.sh.Highlighter.SortCallback=function(e,t){return e.index<t.index?-1:e.index>t.index?1:e.length<t.length?-1:e.length>t.length?1:0},dp.sh.Highlighter.prototype.CreateElement=function(e){var t=document.createElement(e);return t.highlighter=this,t},dp.sh.Highlighter.prototype.GetMatches=function(e,t){for(var s=null;null!=(s=e.exec(this.code));)this.matches[this.matches.length]=new dp.sh.Match(s[0],s.index,t)},dp.sh.Highlighter.prototype.AddBit=function(e,t){if(null!=e&&0!=e.length){var s=this.CreateElement("SPAN");if(e=e.replace(/ /g,"&nbsp;"),e=e.replace(/</g,"&lt;"),e=e.replace(/\n/gm,"&nbsp;<br>"),null!=t)if(/br/gi.test(e))for(var i=e.split("&nbsp;<br>"),n=0;n<i.length;n++)s=this.CreateElement("SPAN"),s.className=t,s.innerHTML=i[n],this.div.appendChild(s),n+1<i.length&&this.div.appendChild(this.CreateElement("BR"));else s.className=t,s.innerHTML=e,this.div.appendChild(s);else s.innerHTML=e,this.div.appendChild(s)}},dp.sh.Highlighter.prototype.IsInside=function(e){if(null==e||0==e.length)return!1;for(var t=0;t<this.matches.length;t++){var s=this.matches[t];if(null!=s&&e.index>s.index&&e.index<s.index+s.length)return!0}return!1},dp.sh.Highlighter.prototype.ProcessRegexList=function(){for(var e=0;e<this.regexList.length;e++)this.GetMatches(this.regexList[e].regex,this.regexList[e].css)},dp.sh.Highlighter.prototype.ProcessSmartTabs=function(e){function t(e,t,s){for(var i=e.substr(0,t),n=e.substr(t+1,e.length),r="",l=0;s>l;l++)r+=" ";return i+r+n}function s(e,s){if(-1==e.indexOf(l))return e;for(var i=0;-1!=(i=e.indexOf(l));){var n=s-i%s;e=t(e,i,n)}return e}for(var i=e.split("\n"),n="",r=4,l="	",o=0;o<i.length;o++)n+=s(i[o],r)+"\n";return n},dp.sh.Highlighter.prototype.SwitchToList=function(){var e=this.div.innerHTML.replace(/<(br)\/?>/gi,"\n"),t=e.split("\n");if(1==this.addControls&&this.bar.appendChild(dp.sh.Toolbar.Create(this)),this.showColumns){for(var s=this.CreateElement("div"),i=this.CreateElement("div"),n=10,r=1;150>=r;)r%n==0?(s.innerHTML+=r,r+=(r+"").length):(s.innerHTML+="&middot;",r++);i.className="columns",i.appendChild(s),this.bar.appendChild(i)}for(var r=0,l=this.firstLine;r<t.length-1;r++,l++){var o=this.CreateElement("LI"),a=this.CreateElement("SPAN");o.className=r%2==0?"alt":"",a.innerHTML=t[r]+"&nbsp;",o.appendChild(a),this.ol.appendChild(o)}this.div.innerHTML=""},dp.sh.Highlighter.prototype.Highlight=function(e){function t(e){return e.replace(/^\s*(.*?)[\s\n]*$/g,"$1")}function s(e){return e.replace(/\n*$/,"").replace(/^\n*/,"")}function i(e){for(var s=dp.sh.Utils.FixForBlogger(e).split("\n"),i=(new Array,new RegExp("^\\s*","g")),n=1e3,r=0;r<s.length&&n>0;r++)if(0!=t(s[r]).length){var l=i.exec(s[r]);null!=l&&l.length>0&&(n=Math.min(l[0].length,n))}if(n>0)for(var r=0;r<s.length;r++)s[r]=s[r].substr(n);return s.join("\n")}function n(e,t,s){return e.substr(t,s-t)}var r=0;if(null==e&&(e=""),this.originalCode=e,this.code=s(i(e)),this.div=this.CreateElement("DIV"),this.bar=this.CreateElement("DIV"),this.ol=this.CreateElement("OL"),this.matches=new Array,this.div.className="dp-highlighter",this.div.highlighter=this,this.bar.className="bar",this.ol.start=this.firstLine,null!=this.CssClass&&(this.ol.className=this.CssClass),this.collapse&&(this.div.className+=" collapsed"),this.noGutter&&(this.div.className+=" nogutter"),1==this.tabsToSpaces&&(this.code=this.ProcessSmartTabs(this.code)),this.ProcessRegexList(),0==this.matches.length)return this.AddBit(this.code,null),this.SwitchToList(),this.div.appendChild(this.bar),void this.div.appendChild(this.ol);this.matches=this.matches.sort(dp.sh.Highlighter.SortCallback);for(var l=0;l<this.matches.length;l++)this.IsInside(this.matches[l])&&(this.matches[l]=null);for(var l=0;l<this.matches.length;l++){var o=this.matches[l];null!=o&&0!=o.length&&(this.AddBit(n(this.code,r,o.index),null),this.AddBit(o.value,o.css),r=o.index+o.length)}this.AddBit(this.code.substr(r),null),this.SwitchToList(),this.div.appendChild(this.bar),this.div.appendChild(this.ol)},dp.sh.Highlighter.prototype.GetKeywords=function(e){return"\\b"+e.replace(/ /g,"\\b|\\b")+"\\b"},dp.sh.BloggerMode=function(){dp.sh.isBloggerMode=!0},dp.sh.HighlightAll=function(e,t,s,i,n,r){function l(){for(var e=arguments,t=0;t<e.length;t++)if(null!=e[t]){if("string"==typeof e[t]&&""!=e[t])return e[t]+"";if("object"==typeof e[t]&&""!=e[t].value)return e[t].value+""}return null}function o(e,t){for(var s=0;s<t.length;s++)if(t[s]==e)return!0;return!1}function a(e,t,s){for(var i=new RegExp("^"+e+"\\[(\\w+)\\]$","gi"),n=null,r=0;r<t.length;r++)if(null!=(n=i.exec(t[r])))return n[1];return s}function h(e,t,s){for(var i=document.getElementsByTagName(s),n=0;n<i.length;n++)i[n].getAttribute("name")==t&&e.push(i[n])}var d=[],c=null,p={},g="innerHTML";if(h(d,e,"pre"),h(d,e,"textarea"),0!=d.length){for(var u in dp.sh.Brushes){var m=dp.sh.Brushes[u].Aliases;if(null!=m)for(var f=0;f<m.length;f++)p[m[f]]=u}for(var f=0;f<d.length;f++){var b=d[f],x=l(b.attributes["class"],b.className,b.attributes.language,b.language),w="";if(null!=x&&(x=x.split(":"),w=x[0].toLowerCase(),null!=p[w])){c=new dp.sh.Brushes[p[w]],b.style.display="none",c.noGutter=null==t?o("nogutter",x):!t,c.addControls=null==s?!o("nocontrols",x):s,c.collapse=null==i?o("collapse",x):i,c.showColumns=null==r?o("showcolumns",x):r;var v=document.getElementsByTagName("head")[0];if(c.Style&&v){var C=document.createElement("style");if(C.setAttribute("type","text/css"),C.styleSheet)C.styleSheet.cssText=c.Style;else{var y=document.createTextNode(c.Style);C.appendChild(y)}v.appendChild(C)}c.firstLine=null==n?parseInt(a("firstline",x,1)):n,c.Highlight(b[g]),c.source=b,b.parentNode.insertBefore(c.div,b)}}}},dp.sh.Brushes.n4js=function(){var e="abstract any as async await break case catch class const continue debugger default delete do else enum export extends external finally for from function get host if implements import in instanceof interface intersection let new of package private project protected public return set static super switch this throw try typeof union var void while with yield";this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:"comment"},{regex:dp.sh.RegexLib.MultiLineCComments,css:"comment"},{regex:dp.sh.RegexLib.DoubleQuotedString,css:"string"},{regex:dp.sh.RegexLib.SingleQuotedString,css:"string"},{regex:new RegExp("\\b([\\d]+(\\.[\\d]+)?|0x[a-f0-9]+)\\b","gi"),css:"number"},{regex:new RegExp("(?!\\@interface\\b)\\@[\\$\\w]+\\b","g"),css:"annotation"},{regex:new RegExp("(?!\\@interface\\b): *[\\{\\}<>~\\$\\w]+\\b","g"),css:"typeannotation"},{regex:new RegExp("\\@interface\\b","g"),css:"keyword"},{regex:new RegExp(this.GetKeywords(e),"gm"),css:"keyword"}],this.CssClass="dp-j",this.Style=".dp-j .annotation { color: #ff00ff; }.dp-j .typeannotation { color: #8c8c8c; }.dp-j .number { color: #2a00ff; }.dp-j .comment { color: #3f7f5f; }.dp-j .keyword { color: #7f0055;}"},dp.sh.Brushes.n4js.prototype=new dp.sh.Highlighter,dp.sh.Brushes.n4js.Aliases=["n4js"],dp.sh.Brushes.Java=function(){var e="abstract assert boolean break byte case catch char class const continue default do double else enum extends false final finally float for goto if implements import instanceof int interface long native new null package private protected public return short static strictfp super switch synchronized this throw throws true transient try void volatile while";this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:"comment"},{regex:dp.sh.RegexLib.MultiLineCComments,css:"comment"},{regex:dp.sh.RegexLib.DoubleQuotedString,css:"string"},{regex:dp.sh.RegexLib.SingleQuotedString,css:"string"},{regex:new RegExp("\\b([\\d]+(\\.[\\d]+)?|0x[a-f0-9]+)\\b","gi"),css:"number"},{regex:new RegExp("(?!\\@interface\\b)\\@[\\$\\w]+\\b","g"),css:"annotation"},{regex:new RegExp("\\@interface\\b","g"),css:"keyword"},{regex:new RegExp(this.GetKeywords(e),"gm"),css:"keyword"}],this.CssClass="dp-j",this.Style=".dp-j .annotation { color: #646464; }.dp-j .number { color: #C00000; }"},dp.sh.Brushes.Java.prototype=new dp.sh.Highlighter,dp.sh.Brushes.Java.Aliases=["java"],dp.sh.Brushes.n4mf=function(){var e="API App Application ArtifactId Colon Comma Compile Content ExecModule ExtendedRuntimeEnvironment External FullStop HyphenMinus ImplementationId ImplementedProjects In InitModules LeftCurlyBracket LeftParenthesis LeftSquareBracket Lib Libraries Library MainModule ModuleFilters NoModuleWrap NoValidate Output Processor ProjectDependencies ProjectName ProjectType ProjectVersion ProvidedRuntimeLibraries RequiredRuntimeLibraries Resources RightCurlyBracket RightParenthesis RightSquareBracket RuntimeEnvironment RuntimeLibrary Source Sources Test TestedProjects User VendorId VendorName";this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:"comment"},{regex:dp.sh.RegexLib.MultiLineCComments,css:"comment"},{regex:dp.sh.RegexLib.DoubleQuotedString,css:"string"},{regex:dp.sh.RegexLib.SingleQuotedString,css:"string"},{regex:new RegExp("\\b([\\d]+(\\.[\\d]+)?|0x[a-f0-9]+)\\b","gi"),css:"number"},{regex:new RegExp("\\@interface\\b","g"),css:"keyword"},{regex:new RegExp(this.GetKeywords(e),"gm"),css:"keyword"}],this.CssClass="dp-j",this.Style=".dp-j .number { color: #2a00ff; }.dp-j .comment { color: #3f7f5f; }.dp-j .keyword { color: #7f0055;}"},dp.sh.Brushes.n4mf.prototype=new dp.sh.Highlighter,dp.sh.Brushes.n4mf.Aliases=["n4mf"],dp.sh.Brushes.plain=function(){this.regexList=[],this.CssClass="dp-j"},dp.sh.Brushes.plain.prototype=new dp.sh.Highlighter,dp.sh.Brushes.plain.Aliases=["plain"];