// Generated by N4JS transpiler; for copyright see original N4JS source file.

(function(System) {
	'use strict';
	System.register([], function($n4Export) {
		var TestDIComponent;
		TestDIComponent = function TestDIComponent() {};
		$n4Export('TestDIComponent', TestDIComponent);
		return {
			setters: [],
			execute: function() {
				$makeClass(TestDIComponent, N4Object, [], {}, {}, function(instanceProto, staticProto) {
					var metaClass = new N4Class({
						name: 'TestDIComponent',
						origin: 'org.eclipse.n4js.mangelhaft',
						fqn: 'org.eclipse.n4js.mangelhaft.types.TestDIComponent.TestDIComponent',
						n4superType: N4Object.n4type,
						allImplementedInterfaces: [],
						ownedMembers: [],
						consumedMembers: [],
						annotations: [
							new N4Annotation({
								name: 'GenerateInjector',
								details: []
							})
						]
					});
					return metaClass;
				});
				Object.defineProperty(TestDIComponent, '$di', {
					value: {
						binders: [],
						fieldsInjectedTypes: []
					}
				});
			}
		};
	});
})(typeof module !== 'undefined' && module.exports ? require('n4js-node/index').System(require, module) : System);
//# sourceMappingURL=TestDIComponent.map
